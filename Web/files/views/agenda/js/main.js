document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar'); 

  var calendar = new FullCalendar.Calendar(calendarEl, {
    locale: 'pt-br',
    plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid', 'list' ],
    header: {
      left: 'prev,next, today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
    },

    aspectRatio: 1.3,
    navLinks: true, 
    editable: true,
    eventLimit: true, 
    events: 'list_eventos.php',

    extraParams: function () {
      return {
        cachebuster: new Date().valueOf()
      };
    },
         
    eventClick: function (info) {
      info.jsEvent.preventDefault();

      $('#visualizar #codigo').val(info.event.id);
      $('#visualizar #titulo').text(info.event.title);
      $('#visualizar #titulo').val(info.event.title);
      $('#visualizar #descricao').text(info.event.extendedProps.description);
      $('#visualizar #descricao').val(info.event.extendedProps.description);
      $('#visualizar #data_ini').text(info.event.start.toLocaleString());
      $('#visualizar #start').val(info.event.start.toLocaleString());
      $('#visualizar #data_fim').text(info.event.end.toLocaleString());
      $('#visualizar #end').val(info.event.end.toLocaleString());
      $('#visualizar #endereco').text(info.event.extendedProps.local);
      $('#visualizar #endereco').val(info.event.extendedProps.local);
      $('#visualizar').modal('show');
    },

    selectable: true,
    selectHelper: true,

    select: function (info) {
      $('#cadastrar #start').val(info.start.toLocaleString());
      $('#cadastrar #end').val(info.end.toLocaleString());
      $('#cadastrar').modal('show');
    }
  });
  calendar.render();
});

//Máscara de data e hora
function DataHora(evento, objeto){
  var keypress=(window.event)?event.keyCode:evento.which;
  campo = eval (objeto);
  if (campo.value == '00/00/0000 00:00:00'){
    campo.value = ""
  }
 
  caracteres = '0123456789';
  separacao1 = '/';
  separacao2 = ' ';
  separacao3 = ':';
  conjunto1 = 2;
  conjunto2 = 5;
  conjunto3 = 10;
  conjunto4 = 13;
  conjunto5 = 16;
  if ((caracteres.search(String.fromCharCode (keypress))!=-1) && campo.value.length < (19)){
    if (campo.value.length == conjunto1 )
    campo.value = campo.value + separacao1;
    else if (campo.value.length == conjunto2)
    campo.value = campo.value + separacao1;
    else if (campo.value.length == conjunto3)
    campo.value = campo.value + separacao2;
    else if (campo.value.length == conjunto4)
    campo.value = campo.value + separacao3;
    else if (campo.value.length == conjunto5)
    campo.value = campo.value + separacao3;
  }else{
    event.returnValue = false;
  }
}