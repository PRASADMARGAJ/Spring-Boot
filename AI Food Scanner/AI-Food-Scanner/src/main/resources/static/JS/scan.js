function uploadImage() {
    let file = document.getElementById("imageInput").files[0];
    if (!file) {
        alert("Please upload an image!");
        return;
    }

    let formData = new FormData();
    formData.append("file", file);

    document.getElementById("scanStatus").innerHTML = "⏳ Scanning...";

    fetch("http://localhost:8080/api/ocr/scan", {
        method: "POST",
        body: formData
    })
        .then(res => res.json())
        .then(data => {
            localStorage.setItem("ocrText", data.text);
            window.location.href = "results.html";
        });
}
