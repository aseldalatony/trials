(function () {
    let items = document.getElementsByTagName("input");
    for (var i = 0; i < items.length; i++) {
        if (items[i].type === 'button') {
            items[i].addEventListener('click', actions);
        }
    }
})()

function actions(event) {
    let src = event.target;
    switch (src.value) {
        case 'c':
            document.calc.output.value = '';
            break;
        case 'x':
            document.calc.output.value += '*';
            break;
        case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
        case '.': case '-': case '+': case '/': case '%': case '(': case ')':
            document.calc.output.value += src.value;
            break;
        case '=':
            document.calc.output.value = eval(document.calc.output.value);
            break;
    }
}
