let sessionId = localStorage.getItem("sessionId");
if (!sessionId) {
    sessionId = crypto.randomUUID();
    localStorage.setItem("sessionId", sessionId);
}

function sendMessage() {
    const msg = document.getElementById("messageInput").value;
    const responseBox = document.getElementById("responseBox");

    if (!msg) {
        responseBox.textContent = "Hvad vil du snakke om?";
        return;
    }

    responseBox.textContent = "Loading...";

    fetch(`/chat?sessionId=${encodeURIComponent(sessionId)}&message=${encodeURIComponent(msg)}`)
        .then(res => res.json())
        .then(data => {
            responseBox.textContent = data.reply || "Ingen svar fra serveren.";
        })
        .catch(err => {
            responseBox.textContent = "Error: " + err;
        });
}

window.onload = function() {
    document.getElementById("responseBox").textContent = "Hvad vil du snakke om?";
};