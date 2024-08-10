//Where I found all the conversions: https://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=EUR
const moneyTypeList = [["USD", "EUR", "GBP", "CNY", "Bitcoin"], [1, 0.93, .8, 7.12, 0.000023]];

//Listener
function startProgram(){
    const inputValue = document.getElementById("inputValue");
    inputValue.addEventListener("input", updateValue);
}
function updateValue(){
    let input = document.getElementById("inputValue").value;
    const outputValue = document.getElementById("outputValue");

    //Convert input
    if(!isNaN(input)){
        let convertToUSD = convertInput(input, "converterOne", false);
        let fullyConverted = convertInput(convertToUSD, "converterTwo", true);
        if(input == ""){
            input = 0;
        }
        outputValue.textContent = "$" + input + " " + converterOne.value + " converts to $" + fullyConverted.toFixed(2) + " " + converterTwo.value;
    }else{
        outputValue.textContent = "You must input a number!";
        document.getElementById("inputValue").value = "";
    }
}
function convertInput(input, className, isUSD){
    const converter = document.getElementById(className).value;
    for(let i=0;i<moneyTypeList[0].length;i++){
        if(moneyTypeList[0][i] == converter){
            if(!isUSD){
                input /= moneyTypeList[1][i];
            }else{
                input *= moneyTypeList[1][i];
            }
        }
    }
    return input;
}