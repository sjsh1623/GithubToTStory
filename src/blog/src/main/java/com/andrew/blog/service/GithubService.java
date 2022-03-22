package com.andrew.blog.service;

import com.andrew.blog.component.HttpTransport;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class GithubService {
    public Map<String, String> getGuthubData(String gitHubUserId, String repoName) throws Exception {
        Map<String,String> gitHubMarkdownData = new HashMap<>();
        String url = "https://api.github.com/repos/{gitHubUserId}/{repoName}/git/trees/master"
                .replace("{gitHubUserId}", gitHubUserId)
                .replace("{repoName}", repoName);

        HttpTransport httpTransport = new HttpTransport(url,"","GET");
        JsonObject result = httpTransport.getResponse();

        System.out.println(result.toString());
        return gitHubMarkdownData;
    }

    public String getMarkdown() {
        return "";
    }

    /**
     * const GithubAPI = (shaTree = "master", path = "") => {
     *     fetch(" https://api.github.com/repos/sjsh1623/Book/git/trees/" + shaTree, {
     *         method: "GET",
     *         headers: {
     *             "Content-Type": "application/json",
     *             "Authorization": "token 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"
     *         },
     *     })
     *         .then((response) => response.json())
     *         .then((data) => {
     *             const isShaExist = !!data.sha
     *             if (isShaExist) extractTreeData(data, path)
     *         });
     * }
     *
     * const extractTreeData = (tree, path) => {
     *     tree.tree.forEach((data => {
     *         const isMarkdown = data.type === "blob" && data.path.includes(".md"); // 마크다운 타입 확인
     *         const isTree = data.type === "tree" // 폴더 트리인지 확인
     *         const encodePath  = encodeURIComponent(data.path);
     *         if(isMarkdown) {
     *             const url = "https://raw.githubusercontent.com/sjsh1623/Book/master/"+path + "/" + encodePath;
     *         } else if(isTree){
     *             GithubAPI(data.sha, path + "/" + encodePath)
     *         }
     *     }))
     * }
     */
}
