
let idx = 1;
let res = [];
const choice = 3;
const digitsCnt = 6;



generateMassive();
printArr(res);
//printArrLine(res);

function generateMassive() {
    for (let j = 0; j < 3; j++) {
        let arr = [];

        for (let i = 0; i < 6; i++) {
            let el = getEl();
            if (arr.includes(el) || res.includes(el)) {
                i--;
            } else {
                arr.push(el);
            }
        }
        res.push(arr);
    }
}


function removeDuplicatedEl(el, arr) {
    let newEl;
    let cnt = 0;
    for(let i = 0; i < arr.length; i++)
        if (arr[i] === el) {
            newEl = getEl();
            arr[i] = newEl;
            //arr.splice(idx1, idx1 - 1, newEl);
        } else arr.push(el);
}

function getEl() {
    return el = (Math.floor(Math.random() * 49) + 1);
}

function printArr(arr) {
    for (let i = 0; i < arr.length; i++) {
        console.log(`${idx++}: ${arr[i]} `);
    }
}


function printArrLine(arr) {
    console.log(`0: ${arr.join("   ")}`);
    printNewLine();
}

function printNewLine() { console.log(` `) }