function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

function ativarValidacaoEmail() {
    // Seleciona todos os formulários da página
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', function(event) {
            // Seleciona inputs que são do tipo email ou que possuem name="email"
            const emailInputs = form.querySelectorAll('input[type="email"], input[name="email"]');

            for (const emailInput of emailInputs) {
                if (!validarEmail(emailInput.value)) {
                    alert(`Email inválido no formulário "${form.id || form.name || 'sem id'}". Por favor, corrija.`);
                    emailInput.focus();
                    event.preventDefault(); // impede o envio do formulário
                    return; // sai do loop para não enviar o form
                }
            }
        });
    });
}

document.addEventListener('DOMContentLoaded', ativarValidacaoEmail);