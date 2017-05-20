package main

import (
	"fmt"
	"html/template"
	"io"
	"log"
	"net/http"
	"os"
)

const (
	UPLOAD_DIR = "public"
	USERNAME   = "admin"
	PASSWORD   = "admin"
)

func main() {
	log.Println("0.0.0.0:8090-Listening...")
	http.HandleFunc("/upload", uploadHandler)
	http.HandleFunc("/do-upload", doUploadHandler)
	http.HandleFunc("/public/", severHandler)
	http.HandleFunc("/notify", notify)
	http.ListenAndServe(":8090", nil)
}

func uploadHandler(w http.ResponseWriter, r *http.Request) {
	username, password, ok := r.BasicAuth()
	if username == USERNAME && password == PASSWORD && ok {
		t := template.New("uploadForm")                    // Create a template.
		t, _ = template.ParseFiles("template/upload.html") // Parse template file.
		t.Execute(w, nil)                                  // merge.
		return
	}
	returnAuth404(w)
}

func doUploadHandler(w http.ResponseWriter, r *http.Request) {
	username, password, ok := r.BasicAuth()
	if r.Method == "POST" && username == USERNAME && password == PASSWORD && ok {
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
		fmt.Fprintf(w, "File uploaded successfully : ")
		fmt.Fprintf(w, header.Filename)
		return
	}
	returnAuth404(w)
}

func severHandler(w http.ResponseWriter, r *http.Request) {
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
	w.Write([]byte("/notify check\n"))
	println("/notifi is called")
}
