function sendMessage() {
    const msg = document.getElementById("messageInput").value;
    const responseBox = document.getElementById("responseBox");

    if (!msg) {
        responseBox.textContent = "Please enter a message first.";
        return;
    }

    responseBox.textContent = "Loading...";

    fetch(`/chat?message=` + encodeURIComponent(msg))
        .then(res => res.json())
        .then(data => {
            console.log(data);
            const choices = data.Choices;

            let text = "";
            choices.forEach((c, index) => {
                text += `Answer ${index + 1}:\n${c.message.content}\n\n`;
            });

            responseBox.textContent = text;
        })
        .catch(err => {
            responseBox.textContent = "Error: " + err;
        });
}