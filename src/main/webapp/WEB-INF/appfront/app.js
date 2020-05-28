

var loginObj = {
    "email": "",
    "password": "",
};
var registerObj = {
    "email": "",
    "password": "",
    "firstname": "",
    "lastname": "",
    "birthdate": null
};

// Nav Link display 
var logoutLinkDiv = document.getElementById('logoutLink');
logoutLinkDiv.hidden = true;
var loginLinkDiv = document.getElementById('loginLink');
loginLinkDiv.hidden = false;
var registerLinkDiv = document.getElementById('registerLink');
registerLinkDiv.hidden = false;


//User Profile 3 
// View 3.1
var divUserProfile = document.createElement('div');
divUserProfile.id = 'userProfile';
//Temp idea

//Funtion pour calcul Age
const getAge = function (birthdate) {
    var diffYears = Date.now() - birthdate.getTime();
    return Math.abs(new Date(diffYears).getUTCFullYear() - 1970);
};

//Login 1
//LoginView 1.0
var divLogin = window.document.createElement('div');
divLogin.id = 'loginDiv';
divLogin.innerHTML = `<h3>LOGIN</h3>`;
var loginForm = window.document.createElement('form');
loginForm.className = 'class="form-group has-errorform-group-xs"';
loginForm.name = 'loginForm';
loginForm.innerHTML = ` <label for="email" class="label label-default">email: </label>
                            <input type="email" class="form-control " minlength="3" max="254" name="email" style="margin-top: 0.5vh;"novalidate>
                        <label for="password" class="label label-default">password: </label>
                            <input type="password"  class="form-control " minlength="3" max="512" name="password" style="margin-top: 0.5vh;" novalidate>
                        <button id="loginBtn"class="btn disabled" type="submit"> SUBMIT </button>`;

//1.2
//Login Listener on Submit => Request http Post on http:8080/login
loginForm.addEventListener('submit', function (evt) {
    evt.preventDefault();
    console.log('Submit the form');
    loginObj.email = `${evt.target[0].value}`;
    loginObj.password = `${evt.target[1].value}`;
    //1.3*
    login(loginObj);
    //Reset Input after Submit
    for (let index = 0; index < evt.target.length; index++) {
        evt.target[index].value = "";
    }
});

//Listener to Open LoginView 1.1
document.getElementById('loginLink').addEventListener('click', function (evt) {
    evt.preventDefault();
    //CLick on Login => open LoginView
    document.getElementById('view').innerHTML = "";
    divLogin.appendChild(loginForm);
    document.getElementById('view').appendChild(divLogin);

    var input = document.getElementsByTagName('input');
    var boolEmailValid = false; 
    input.email.addEventListener("focusout", function (evt) {
        evt.preventDefault();
        if (input.email.value.trim() < 1 ){
            boolEmailValid = true;
            console.log('Blank ')
            document.getElementById('loginBtn').className = "btn btn-primary disabled";
        } else {
            if (input.email.value.length < 3) {
                boolEmailValid = true;
                document.getElementById('loginBtn').className = "btn btn-primary disabled";
            } else {
                console.log("GOOD EMAIL ");
                boolEmailValid = false;
            }
        }
    })
    input.password.addEventListener("focusout", function (evt) {
        evt.preventDefault();
        if (input.password.value.trim() < 1 ){
            document.getElementById('loginBtn').className = "btn btn-primary disabled";
        } else {
            if (input.password.value.length < 3 || boolEmailValid) {
                document.getElementById('loginBtn').className = "btn btn-primary disabled";
            } else {
                document.getElementById('loginBtn').className = "btn btn-primary active";
            }
        }
    })

})


//Function Login  => Post {} 1.3*
const login = function (loginObj) {
    const url = `http://localhost:8080/login`;
    const method = "POST";
    const xhr = new XMLHttpRequest();
    xhr.open(method, url);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(loginObj));

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status == 200) {
            var ageNum = new Date(userObj.birthdate);
            var age = getAge(ageNum);
            //Ajout du lien de logOut
            loginLinkDiv.hidden = true;
            logoutLinkDiv.hidden = false;
            registerLinkDiv.hidden = true;
            //Vider view
            window.document.getElementById('view').innerHTML = "";

            divUserProfile.innerHTML = `<div class="container bg-3 text-center" style="background-color:crimson;width: auto !important;">
                                            <h3>Your Profile</h3>
                                            <p>First Name: ${userObj.firstname} </p>
                                            <p>Last Name : ${userObj.lastname} </p>
                                            <p>Age :${age} years </p>
                                        </div>
                                        <div id="message" class="container bg-4 text-center" style="background-color:gold;width: auto !important;">
                                            <h3>Message Section </h3>
                                            <div id="inputMsg">
                                            <label for="inputMsg">Chat with Friends</label>
                                                <input type="textarea" placeholder="Enter your message">
                                            </div>
                                            <div id="readMsg">
                                            <label for="prevMsg">Latest posts: </label>
                                                <p>Previous Message<p>
                                            </div>
                                        </div>
                                            `;
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-success ">
                                                                    <a href="#" onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Successfully connected</p>
                                                                </div>`;
            document.getElementById('view').appendChild(divUserProfile);
        } else if (this.readyState === 4 && this.status == 500) {
            console.log('500');
        } else if (this.readyState === 4 && this.status == 400) {
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-danger">
                                                                    <a href="#" onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Incorrect email or password</p>
                                                                </div>`;
        } else if (this.readyState === 4 && this.status == 401) {
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-danger">
                                                                    <a href="#" onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Incorrect email or password</p>
                                                                </div>`;
        }
    }
};

//Register 2
//RegisterView 2.0
var divRegister = document.createElement('div');
divRegister.id = 'loginDiv';
divRegister.innerHTML = `<h3>Register</h3>`;
var registerForm = window.document.createElement('form');
registerForm.name = 'registerForm';
registerForm.className = 'class="form-group form-group-xs"';
registerForm.innerHTML = ` <label for="email" class="label label-default">email: </label>
                                <input type="text"  class="form-control input-sm" minlength="3" max="254" name="email" style="margin-top: 0.5vh;" novalidate>
                            <label for="password" class="label label-default">password: </label>
                                <input type="password" class="form-control input-sm" minlength="3" max="512"name="password" style="margin-top: 0.5vh;" novalidate>
                            <label for="firstname" class="label label-default">First name: </label>
                                <input type="text" class="form-control input-sm" minlength="3" max="512" name="firstname" style="margin-top: 0.5vh;" novalidate>
                            <label for="lastname" class="label label-default">Last name: </label>
                                <input type="text" class="form-control input-sm" minlength="3" max="512" name="lastname" style="margin-top: 0.5vh;" novalidate>
                            <label for="birthdate" class="label label-default">Birthdate: </label>
                                <input type="date" class="form-control input-sm" max="2002-01-01" name="birthdate" style="margin-top: 0.5vh;" novalidate>
                            <button class="btn" type="submit"> SUBMIT </button>`;

//2.2
//register Listener on Submit => Request http Post on http:8080/register
registerForm.addEventListener('submit', function (evt) {
    evt.preventDefault();
    console.log('Submit the Register form');
    registerObj.email = `${evt.target[0].value}`;
    registerObj.password = `${evt.target[1].value}`;
    registerObj.firstname = `${evt.target[2].value}`;
    registerObj.lastname = `${evt.target[3].value}`;
    registerObj.birthdate = evt.target[4].value;
    console.log(registerObj);
    //2.3*
    register(registerObj);
    //Reset Input after Submit
    for (let index = 0; index < evt.target.length; index++) {
        evt.target[index].value = "";
    }
});


//Listener to Open RegisterView 2.1
document.getElementById('registerLink').addEventListener('click', function (evt) {
    evt.preventDefault();
    //CLick on register => open registerView
    divRegister.appendChild(registerForm);
    window.document.getElementById('view').innerHTML = "";
    window.document.getElementById('view').appendChild(divRegister);
})

//Function register  => Post {} 2.3*
const register = function (registerObj) {
    const url = `http://localhost:8080/register`;
    const method = "POST";
    const xhr = new XMLHttpRequest();
    xhr.open(method, url);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(registerObj));

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status == 200) {
            console.log('OK -- 200');
            //Ajout du lien de logOut
            logoutLinkDiv.hidden = false;
            //Retirer lien de Register
            registerLinkDiv.hidden = true;
            //Vider view
            window.document.getElementById('view').innerHTML = "";
            //View Profil à insérer dans le DOM
            //Alert 
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-success">
                                                                    <a href="#" onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Successful registration ! You can now use your credentials</p>
                                                                </div>`;
        } else if (this.readyState === 4 && this.status == 500) {
            console.log('500');
        } else if (this.readyState === 4 && this.status == 400) {
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-danger">
                                                                    <a href="#"  onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Incorrect email or password</p>
                                                                </div>`;
        } else if (this.readyState === 4 && this.status == 401) {
            document.getElementById('alertView').innerHTML = ` <div class="alert alert-danger">
                                                                    <a href="#"  onclick="closeAlert()" class="close" aria-label="close">&times;</a>
                                                                    <p>Incorrect email or password</p>
                                                                </div>`;
        }
    }
};

//LogOut 
logoutLinkDiv.addEventListener('click', function (evt) {
    evt.preventDefault();
    //unlog User 

    // Nav Link display 
    logoutLinkDiv.hidden = true;
    loginLinkDiv.hidden = false;
    registerLinkDiv.hidden = false;
    //
    document.getElementById('view').innerHTML = "";

});

var closeAlert = function () {
    var closeAlerts = document.getElementsByClassName("close");

    closeAlerts[0].addEventListener('click', function (evt) {
        evt.preventDefault();
        document.getElementById('alertView').innerHTML = "";
    })
}
