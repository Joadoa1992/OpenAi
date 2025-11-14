function sendMessage() {
    const msg = document.getElementById("messageInput").value;
    const responseBox = document.getElementById("responseBox");

    if (!msg) {
        responseBox.textContent = "Hvad vil du snakke om?";
        return;
    }

    responseBox.textContent = "Loading...";

    fetch(`/chat?message=` + encodeURIComponent(msg))
        .then(res => res.json())
        .then(data => {
            console.log(data);
            const choices = data.Choices ?? data.choices;

            let text = "";
            choices.forEach((c) => {
                text += `${c.message.content}\n\n`;
            });

            responseBox.textContent = text;
        })
        .catch(err => {
            responseBox.textContent = "Error: " + err;
        });
}

window.onload = function() {
    document.getElementById("responseBox").textContent = "Hvad vil du snakke om?";
};
