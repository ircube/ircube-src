
/**
 * Initializes the Google API JavaScript client. Bootstrap the angular module after loading the Google libraries
 * so that Google JavaScript library ready in the angular modules.
 */
console.log('script');

function fx (){
  alert('yeah');
}


var init = function() {
  console.log('init');
  var apisToLoad;
  var loadCallback = function() {
    if (--apisToLoad == 0) {
      signin(true, userAuthed);
    }
  };

  apisToLoad = 2; // must match number of calls to gapi.client.load()
  var ROOT = '//' + window.location.host + '/_ah/api';
  gapi.client.load('apiircubesrc', 'v1', loaded, ROOT);
  gapi.client.load('oauth2', 'v2', loadCallback);
};

function loaded(){
  console.log(' EndPoint apiircubesrc cargado');
  document.body.style.background = "#ffE3E3";
  hide(document.getElementById("signoutButton"));
  show(document.getElementById("signinButton"));
}

function signin(mode, authorizeCallback) {
  gapi.auth.authorize({
        client_id: '1057901676819-26gl5lff79aehu3bbtokur9lt40s9mv5.apps.googleusercontent.com',
        scope: 'https://www.googleapis.com/auth/userinfo.email',
        immediate: mode},
      authorizeCallback);
}

function userAuthed() {

  document.body.style.background = "#00FF00";

  show(document.getElementById("signoutButton"));
  hide(document.getElementById("signinButton"));
  var request =
      gapi.client.oauth2.userinfo.get().execute(function(resp) {
        if (!resp.code) {
          gapi.client.apiircubesrc.login().execute(
              function (resp){
                if(resp.error){

                }else{
                  console.log(resp.result.name);
                }
              }
          )
          // User is signed in, call my Endpoint
        }
      });
}


function auth() {
  signin(false, userAuthed);
};
function signOut(){
  document.body.style.background = "#FFE3E3";
  hide(document.getElementById("signoutButton"));
  show(document.getElementById("signinButton"));
}



function show(el) {
  el.style.display = "visible";
}

function hide(el) {
  el.style.visibility = "hidden";
}

