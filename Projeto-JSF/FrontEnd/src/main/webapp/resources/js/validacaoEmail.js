function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

function ativarValidacaoEmail() {
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', function(event) {

            const emailInputs = form.querySelectorAll('input[id$="email"]');

            for (const emailInput of emailInputs) {
                const valorEmail = emailInput.value.trim();

                if (valorEmail !== '' && !validarEmail(valorEmail)) {
                    alert(`E-mail inválido! Por favor, corrija.`);
                    emailInput.focus();
                    event.preventDefault();
                    return;
                }
            }
        });
    });
}

document.addEventListener('DOMContentLoaded', ativarValidacaoEmail);