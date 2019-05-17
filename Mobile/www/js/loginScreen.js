var btnAvancar = document.getElementById('btn-avancar');
var btnVoltar = document.getElementById('btn-voltar');
var insideBox = document.getElementById('login-inside-box');
var emailBox = document.getElementById('box-email');
var passBox = document.getElementById('box-password');

window.onload = function() {
  	insideBox.classList.add('fade-initial');
	insideBox.classList.remove('no-fade');
	emailBox.classList.remove('transparent');
	passBox.classList.add('transparent');
};

btnAvancar.addEventListener('click', function() {
	insideBox.classList.remove('fade-initial');
	insideBox.classList.add('fade-esquerda');
	emailBox.classList.add('transparent');
	emailBox.classList.remove('block');
	passBox.classList.add('block');
	passBox.classList.remove('transparent');
});

btnVoltar.addEventListener('click', function() {
	insideBox.classList.add('fade-initial');
	insideBox.classList.remove('fade-esquerda');
	emailBox.classList.remove('transparent');
	emailBox.classList.add('block');
	passBox.classList.remove('block');
	passBox.classList.add('transparent');
});