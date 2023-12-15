document.getElementById("registration-form").addEventListener("submit", function(event) {
    event.preventDefault();
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var errorMessage = document.getElementById("error-message");

    // Validar campos (puedes agregar más validaciones según tus necesidades)
    if (name === "" || email === "" || password === "") {
        errorMessage.textContent = "Todos los campos son obligatorios.";
    } else {
        // Enviar datos del formulario a tu servidor aquí (usando AJAX, Fetch API, etc.)
        // Por ejemplo:
        // fetch('/ruta-al-servidor', {
        //     method: 'POST',
        //     body: JSON.stringify({ name, email, password }),
        //     headers: {
        //         'Content-Type': 'application/json'
        //     }
        // })
        // .then(response => response.json())
        // .then(data => {
        //     // Manejar la respuesta del servidor aquí
        // })
        // .catch(error => {
        //     // Manejar errores de la solicitud aquí
        // });
        
        // Limpiar el mensaje de error si la validación es exitosa
        errorMessage.textContent = "";
        // Redirigir al usuario a otra página o mostrar un mensaje de éxito
        alert("Registro exitoso. Redirigiendo a la página principal...");
        // window.location.href = '/ruta-de-destino'; // Redirigir a otra página
    }
});
