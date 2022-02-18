// 깃 허브의 Folder Tree를 가져온다
const key = "1f70d32ba9f9456450e2279374292db4";
const githubRepoTree = (shaTree = "master", path = "") => {
    fetch(" https://api.github.com/repos/sjsh1623/Book/git/trees/" + shaTree, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "token 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"
        },
    })
        .then((response) => response.json())
        .then((data) => {
            const isShaExist = !!data.sha
            if (isShaExist) extractTreeData(data, path)
        });
}

const extractTreeData = (tree, path) => {
    tree.tree.forEach((data => {
        const isMarkdown = data.type === "blob" && data.path.includes(".md"); // 마크다운 타입 확인
        const isTree = data.type === "tree" // 폴더 트리인지 확인
        const encodePath  = encodeURIComponent(data.path);
        if(isMarkdown) {
            const url = "https://raw.githubusercontent.com/sjsh1623/Book/master/"+path + "/" + encodePath;
        } else if(isTree){
            githubRepoTree(data.sha, path + "/" + encodePath)
        }
    }))
}

const TstoryOAuth = () => {
    let requestURL = "https://www.tistory.com/oauth/authorize?client_id={client-id}&redirect_uri={redirect-uri}&response_type=code"
        .replace("{client-id}", key)
        .replace("{redirect-uri}", "http://localhost:7777/TstoryCallback")
    console.log(requestURL)
    window.open(requestURL, "_black", "popup")
}
//githubRepoTree()
TstoryOAuth()