const TStoryOAuth = () => {
    const requestURL = "https://www.tistory.com/oauth/authorize?client_id={client-id}&redirect_uri={redirect-uri}&response_type=code"
        .replace("{client-id}", key)
        .replace("{redirect-uri}", "http://localhost:7777/GithubToTStory/main/TstoryCallback.html")
    window.open(requestURL, "_black", "popup")
}

export default TStoryOAuth;