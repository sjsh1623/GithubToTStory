const GithubAPI = (shaTree = "master", path = "") => {
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
            GithubAPI(data.sha, path + "/" + encodePath)
        }
    }))
}

export default GithubAPI;