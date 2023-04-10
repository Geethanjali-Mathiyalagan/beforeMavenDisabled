var cardNumberError = document.getElementById("cardNumberError");
var mmExpireError = document.getElementById("mmExpireError");
var yyyyExpireError = document.getElementById("yyyyExpireError");
var pinError = document.getElementById("pinError");
var mobileNoError = document.getElementById("mobile-error");
var text;
var message;
function mobileNoValidation() {
    var mobileNumber = document.getElementById('no').value;
    let mobileNoValidate = /^[0-9]{10}$/;
    if (mobileNumber.length === 0) {
        text = 'Mobile Number is required';
        mobileNoError.innerHTML = text;
         document.getElementById("no").style.border = "2px solid red";
        return false;
    }
    if (mobileNumber.length !== 10) {
        text = 'Mobile Number should be 10 digits';
        mobileNoError.innerHTML = text;
        document.getElementById("no").style.border = "2px solid red";
        return false;
    }
    if (!mobileNumber.match(mobileNoValidate)) {
       text = 'Mobile Number is required';
        mobileNoError.innerHTML = text;
        document.getElementById("no").style.border = "2px solid red";
        return false;
    }
    mobileNoError.innerHTML =null;
    document.getElementById("no").style.border = "2px solid green";
    return true;
}
//card number validation
function cardNumberValidate() {
let cardNumber = document.querySelector("#cardDetail").value;
let cardNumberCheck = /^[2-9]{1}[0-9]{3}(\s{1})?[0-9]{4}(\s{1})?[0-9]{4}(\s{1})?[0-9]{4}$/;
if (!cardNumber.match(cardNumberCheck)) {
  message = "Enter 16 Digit Card Number!";
cardNumberError.innerHTML = message;
document.getElementById("cardDetail").style.border = "2px solid red";
return false;

}
message = null;
cardNumberError.innerHTML = message;
document.getElementById("cardDetail").style.border = "2px solid green";
return true;

}
//validate month
function expiryValidate() {

let mm = document.querySelector("#dateyear").value;
let mmCheck =/^(0?[1-9]|1[0-2])$/;
if (!mm.match(mmCheck)) {
message = "Enter valid month!";
mmExpireError.innerHTML = message;
document.getElementById("dateyear").style.border = "2px solid red";
return false;
}
message = null;
mmExpireError.innerHTML = message;
document.getElementById("dateyear").style.border = "2px solid green";
return true;
}
function yearValidate() {
let mm = document.querySelector("#year").value;
let mmCheck = /^20[2-9][3-9]|[3-9][0-9]$/;
if (!mm.match(mmCheck)) {
message = "Enter valid year!";
yyyyExpireError.innerHTML = message;
document.getElementById("year").style.border = "2px solid red";
return false;
}
message = null;
yyyyExpireError.innerHTML = message;
document.getElementById("year").style.border = "2px solid green";
return true;
}
//validate pin
function pinValidate() {

let pin = document.querySelector("#pin").value;
let pinCheck = /^\d{3}$/;
if (!pin.match(pinCheck)) {
message = "CVV should be 3 digits!";
pinError.innerHTML = message;
document.getElementById("pin").style.border = "2px solid red";
return false;
}
message = null;
pinError.innerHTML = message;
document.getElementById("pin").style.border = "2px solid green";
return true;
}
