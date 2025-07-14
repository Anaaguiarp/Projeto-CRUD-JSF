function carregarEstadosECidades(idForm, idEstado, idCidade) {
    document.addEventListener('DOMContentLoaded', () => {
        const selectEstado = document.getElementById(idForm + ':' + idEstado);
        const selectCidade = document.getElementById(idForm + ':' + idCidade);

        if (!selectEstado || !selectCidade) {
            console.warn('Elementos de estado ou cidade não encontrados.');
            return;
        }

        const estadoSelecionado = selectEstado.getAttribute('data-estado-salvo');
        const cidadeSelecionada = selectCidade.getAttribute('data-cidade-salvo');

        fetch('https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome')
            .then(res => res.json())
            .then(estados => {
                estados.forEach(estado => {
                    const option = document.createElement('option');
                    option.value = estado.sigla;
                    option.textContent = estado.nome;

                    if (estado.sigla === estadoSelecionado) {
                        option.selected = true;
                        carregarCidades(estado.sigla);
                    }

                    selectEstado.appendChild(option);
                });
            });

        selectEstado.addEventListener('change', () => {
            const estadoSigla = selectEstado.value;
            carregarCidades(estadoSigla);
        });

        function carregarCidades(estadoSigla) {
            selectCidade.innerHTML = '<option value="">Carregando cidades...</option>';

            fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoSigla}/municipios`)
                .then(res => res.json())
                .then(cidades => {
                    selectCidade.innerHTML = '<option value="">Selecione uma cidade</option>';
                    cidades.forEach(cidade => {
                        const option = document.createElement('option');
                        option.value = cidade.nome;
                        option.textContent = cidade.nome;

                        if (cidade.nome === cidadeSelecionada) {
                            option.selected = true;
                        }

                        selectCidade.appendChild(option);
                    });
                });
        }
    });
}
