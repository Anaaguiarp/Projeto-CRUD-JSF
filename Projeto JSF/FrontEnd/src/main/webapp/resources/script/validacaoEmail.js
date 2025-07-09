/**
 * Função que valida se o email está no formato correto.
 * @param {string} email - O email a ser validado.
 * @returns {boolean} - true se válido, false se inválido.
 */
function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

/**
 * Função que adiciona o listener de validação para todos os formulários da página.
 * Ela busca todos os formulários e, em cada um, verifica os inputs que são do tipo email
 * ou que tenham o atributo name="email". Na submissão, valida o email e impede envio se inválido.
 */
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

// Quando o DOM estiver completamente carregado, ativa a validação nos formulários
document.addEventListener('DOMContentLoaded', ativarValidacaoEmail);