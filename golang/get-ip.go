package main

import (
	"log"
	"net"
	"net/http"
)

func main() {
	log.Println("Application is listening on 9090...")
	http.HandleFunc("/", index)
	http.ListenAndServe(":9090", nil)
}

func index(w http.ResponseWriter, r *http.Request) {
	ip, _, _ := net.SplitHostPort(r.RemoteAddr)
	log.Println("Remote address: " + ip)
}
