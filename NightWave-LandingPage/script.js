document.querySelectorAll('.button').forEach(button => {
    button.addEventListener('click', function(event) {
        event.preventDefault();
        document.querySelector('#about').scrollIntoView({ behavior: 'smooth' });
    });
});
