document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault();

    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var loginData = {
        email: email,
        senha: password
    };

    fetch("http://localhost:8080/auth/autenticacao", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Falha na autenticação");
            }
        })
        .then(data => {
            // Verifica se o login está correto
            if (loginCorreto(data)) {
                // Redireciona o usuário para a página anuncios_criados.html
                window.location.href = "anuncios_criados.html";
            } else {
                alert("Credenciais inválidas. Verifique seus dados de login.");
            }
        })
        .catch(error => {
            console.error(error);
            alert("Falha na autenticação. Verifique suas credenciais.");
        });
});

function loginCorreto(data) {
    // Verifica se o objeto de dados existe e contém a propriedade "token"
    if (data && data.hasOwnProperty("token")) {
        // Verifica se o token não é nulo ou vazio
        if (data.token) {
            return true; // Login correto
        }
    }

    return false; // Login incorreto
}
