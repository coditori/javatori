package main

import (
	"fmt"
	"html/template"
	"io"
	"log"
	"net/http"
	"os"
	"time"
	"github.com/gorilla/mux"
	"github.com/sethvargo/go-password/password"
	// "gopkg.in/natefinch/lumberjack.v2"
)

var authPass,err = password.Generate(32, 10, 10, false, false)

const (
	UPLOAD_DIR = "public"
	PUBLIC_URL = "/public/"
	USERNAME   = "massoud"
)

func main() {

	// log.SetOutput(&lumberjack.Logger{
	//     Filename:   "/var/log/myapp/foo.log",
	//     MaxSize:    500, // megabytes
	//     MaxBackups: 3,
	//     MaxAge:     28, //days
	//     Compress:   true, // disabled by default
	// })

	log.Println("0.0.0.0:1530-Listening...")

	if err != nil {
		log.Fatal(err)
	}
	log.Println("authPass", authPass)

	r := mux.NewRouter()
	r.HandleFunc("/upload", uploadHandler).Methods("GET")
	r.HandleFunc("/upload", doUploadHandler).Methods("POST")
	r.HandleFunc("/public/", severHandler)
	r.HandleFunc("/public/{.*}", severHandler)
	r.HandleFunc("/notify", notify).Methods("GET")

	srv := &http.Server{
        Handler:      r,
        Addr:         "0.0.0.0:1530",
        // Good practice: enforce timeouts for servers you create!
        WriteTimeout: 15 * time.Second,
        ReadTimeout:  15 * time.Second,
    }

    log.Fatal(srv.ListenAndServe())
}

func uploadHandler(w http.ResponseWriter, r *http.Request) {
	username, pass, ok := r.BasicAuth()
	if username == USERNAME && authPass == pass && ok {
		t := template.New("uploadForm")                    // Create a template.
		t, _ = template.ParseFiles("template/upload.html") // Parse template file.
		t.Execute(w, nil)                                  // merge.
		return
	}
	returnAuth404(w)
}

func doUploadHandler(w http.ResponseWriter, r *http.Request) {
	username, pass, ok := r.BasicAuth()
	if r.Method == "POST" && username == USERNAME && authPass == pass && ok {
		file, header, err := r.FormFile("file")
		if err != nil {
			fmt.Fprintln(w, err)
			return
		}
		defer file.Close()
		_, err = os.Stat(UPLOAD_DIR)
		if err != nil {
			err = os.Mkdir(UPLOAD_DIR, os.ModePerm)
			if err != nil {
				fmt.Fprintf(w, "Unable to <b>create "+UPLOAD_DIR+" directory</b>. Check your write access privilege")
			}
		}
		out, err := os.Create(UPLOAD_DIR + "/" + header.Filename)
		if err != nil {
			fmt.Fprintf(w, "Unable to <b>create the file for writing</b>. Check your write access privilege")
			return
		}
		defer out.Close()
		_, err = io.Copy(out, file)
		if err != nil {
			fmt.Fprintln(w, err)
		}
		http.Redirect(w, r, PUBLIC_URL, http.StatusTemporaryRedirect)
		fmt.Fprintf(w, header.Filename)
		return
	}
	returnAuth404(w)
}

func severHandler(w http.ResponseWriter, r *http.Request) {
	log.Println("request", r.URL.Path[1:])
	//	username, password, ok := r.BasicAuth()
	//	if username == USERNAME && password == PASSWORD && ok {
	http.ServeFile(w, r, r.URL.Path[1:])
	//		return
	//	}

	//	returnAuth404(w)
}

func returnAuth404(w http.ResponseWriter) http.ResponseWriter {
	w.Header().Set("WWW-Authenticate", `Basic realm="Beware! Protected REALM! "`)
	w.WriteHeader(401)
	w.Write([]byte("401 Unauthorized\n"))
	return w
}

func notify(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("/notify"))
	println("/notify is called")
}
