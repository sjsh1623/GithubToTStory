const TStoryOAuth = () => {
    const key = "1f70d32ba9f9456450e2279374292db4";
    const requestURL = "https://www.tistory.com/oauth/authorize?client_id={client-id}&redirect_uri={redirect-uri}&response_type=code"
        .replace("{client-id}", key)
        .replace("{redirect-uri}", "http://localhost:7777/GithubToTStory/main/TstoryCallback.html")

    fetch(requestURL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin" : "*"
        }
    })
        .then((response) => console.log(response))
        .then((data) => {

        });
    //window.open(requestURL, "_black", "popup")
}

export default TStoryOAuth;