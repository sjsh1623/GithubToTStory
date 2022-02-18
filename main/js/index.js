// 깃 허브의 Folder Tree를 가져온다
const githubRepoTree = (shaTree = "master") => {
    fetch(" https://api.github.com/repos/sjsh1623/Book/git/trees/" + shaTree, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",

        },
    })
        .then((response) => response.json())
        .then((data) => {
            const isShaExist = !!data.sha
            if (isShaExist) extractTreeData(data)
        });
}

const extractTreeData = (tree) => {
    tree.tree.forEach((data => {
        const isMarkdown = data.type === "blob" && data.path.includes(".md");
        console.log(isMarkdown)
        if(isMarkdown) {
            console.log('markdown: ' + data.path);
        } else {
            console.log('folder: ' + data.path)
            githubRepoTree(data.sha)
        }
    }))
}


githubRepoTree();