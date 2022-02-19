const url = new URL(window.location.href);
const urlSearch = url.searchParams;
const AuthorizationCode = urlSearch.get("code")
const appId = "1f70d32ba9f9456450e2279374292db4";
const clientSecret = ""
const AccessTokenURL = "https://www.tistory.com/oauth/access_token?client_id={client-id}&client_secret={client-secret}&redirect_uri={redirect-uri}&code={code}&grant_type=authorization_code"
    .replace("{client-id}", appId)
    .replace("{client-secret}",clientSecret)
    .replace("{redirect-uri}", "http://localhost:7777/GithubToTStory/main/TstoryCallback.html")
    .replace("{code}", AuthorizationCode)

fetch(AccessTokenURL, {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin" : "*"
    }
})
    .then((response) => console.log(response))
    .then((data) => {

    });
