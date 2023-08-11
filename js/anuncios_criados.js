
// Função para criar um card de anúncio
function criarCardAnuncio(anuncio) {
    var card = document.createElement('div');
    card.classList.add('card-anuncios');

    var titulo = document.createElement('h3');
    titulo.textContent = anuncio.titulo;
    card.appendChild(titulo);

    var descricao = document.createElement('p');
    descricao.textContent = anuncio.descricao;
    card.appendChild(descricao);

    var valorLavagem = document.createElement('p');
    valorLavagem.textContent = 'Valor da Lavagem: R$ ' + anuncio.valorLavagem.toFixed(2);
    card.appendChild(valorLavagem);

    // Adicionar evento de clique para abrir os detalhes do anúncio
    card.addEventListener('click', function() {
        abrirDetalhesAnuncio(anuncio);
    });
    
    return card;
}

function abrirDetalhesAnuncio(anuncio) {
    // Formatar os dados do anúncio para passar para a tela detalhes_anuncios
    var dadosAnuncio = {
        titulo: anuncio.titulo,
        descricao: anuncio.descricao,
        valorLavagem: anuncio.valorLavagem
    };

    // Serializar os dados do anúncio para passar como query string na URL
    var query = encodeURIComponent(JSON.stringify(dadosAnuncio));

    // Abrir a nova tela (detalhes_anuncios) com os dados do anúncio
    window.open('tela_pagamento.html?' + query, '_blank');
}

// Função para exibir os anúncios na tela
function exibirAnuncios(anuncios) {
    var container = document.getElementById('anunciosContainer');

    anuncios.forEach(function (anuncio) {
        var card = criarCardAnuncio(anuncio);
        container.appendChild(card);
    });
}

// Buscar os anúncios da API via Fetch
fetch('http://localhost:8080/anuncios')
    .then(function (response) {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Erro na requisição');
        }
    })
    .then(function (anuncios) {
        exibirAnuncios(anuncios);
    })
    .catch(function (error) {
        console.error('Erro na requisição:', error);
    });

// Função para voltar para a tela de criação
function voltar() {
    window.location.href = 'index.html';
}

// Função para editar um anúncio
function editarAnuncio(proprietarioId, anuncioId) {
    // Redirecionar para a tela de edição com o ID do anúncio e do proprietário
    window.location.href = `editar-anuncio.html?proprietarioId=${proprietarioId}&anuncioId=${anuncioId}`;
}
