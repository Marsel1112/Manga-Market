function applyForm3Styles(formContainer) {
    const buttonStyle = formContainer.querySelector("button[type='submit']").style;
    buttonStyle.width = '864px';
    buttonStyle.padding = '10px';
    buttonStyle.cursor = 'pointer';
    buttonStyle.left = '40%';
    buttonStyle.border = 'none';
    buttonStyle.margin = '10px';
    buttonStyle.borderRadius = '8px';
    buttonStyle.backgroundColor = '#c373e8';

    const inputStyle1 = formContainer.querySelector("input[type='text1']");
    const inputStyle2 = formContainer.querySelector("input[type='text2']");
    const inputStyle3 = formContainer.querySelector("input[type='text3']");
    const inputStyle4 = formContainer.querySelector("input[type='text4']");

    getStyle(inputStyle1);
    getStyle(inputStyle2);
    getStyle(inputStyle3);
    getStyle(inputStyle4);

    const inputStyle5 = formContainer.querySelector("input[type='textUrl']");
    getStyle(inputStyle5);
    inputStyle5.style.width = '844px';
    function getStyle(inputStyle){
        inputStyle.style.width = '400px'
        inputStyle.style.margin = '10px'
        inputStyle.style.padding = '10px'
        inputStyle.style.backgroundColor = '#4C2C59';
        inputStyle.style.color = '#f3f1f1';
        inputStyle.style.border = 'none';
        inputStyle.style.borderRadius = '8px';
        inputStyle.style.cursor = 'pointer';
        inputStyle.style.fontSize = '16px';
    }
}

