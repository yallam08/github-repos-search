package com.example.githubsearch.data.remote_data_source

import com.example.githubsearch.data.repository.DataSource
import com.example.githubsearch.remote.ApiInterface
import com.example.githubsearch.remote.model.GitHubSearchReposResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import java.lang.reflect.Type
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) : DataSource {

    override suspend fun searchRepos(query: String): GitHubSearchReposResponse {
        delay(1000)

        val type: Type = object : TypeToken<GitHubSearchReposResponse>() {}.type
        val gson = Gson()

        return gson.fromJson("{\n" +
                "  \"total_count\": 5762784,\n" +
                "  \"incomplete_results\": false,\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"id\": 103826539,\n" +
                "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMDM4MjY1Mzk=\",\n" +
                "      \"name\": \"uiautomator2\",\n" +
                "      \"full_name\": \"openatx/uiautomator2\",\n" +
                "      \"private\": false,\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"openatx\",\n" +
                "        \"id\": 20634838,\n" +
                "        \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjIwNjM0ODM4\",\n" +
                "        \"avatar_url\": \"https://avatars.githubusercontent.com/u/20634838?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/openatx\",\n" +
                "        \"html_url\": \"https://github.com/openatx\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/openatx/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/openatx/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/openatx/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/openatx/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/openatx/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/openatx/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/openatx/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/openatx/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/openatx/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"html_url\": \"https://github.com/openatx/uiautomator2\",\n" +
                "      \"description\": \"Android Uiautomator2 Python Wrapper\",\n" +
                "      \"fork\": false,\n" +
                "      \"url\": \"https://api.github.com/repos/openatx/uiautomator2\",\n" +
                "      \"forks_url\": \"https://api.github.com/repos/openatx/uiautomator2/forks\",\n" +
                "      \"keys_url\": \"https://api.github.com/repos/openatx/uiautomator2/keys{/key_id}\",\n" +
                "      \"collaborators_url\": \"https://api.github.com/repos/openatx/uiautomator2/collaborators{/collaborator}\",\n" +
                "      \"teams_url\": \"https://api.github.com/repos/openatx/uiautomator2/teams\",\n" +
                "      \"hooks_url\": \"https://api.github.com/repos/openatx/uiautomator2/hooks\",\n" +
                "      \"issue_events_url\": \"https://api.github.com/repos/openatx/uiautomator2/issues/events{/number}\",\n" +
                "      \"events_url\": \"https://api.github.com/repos/openatx/uiautomator2/events\",\n" +
                "      \"assignees_url\": \"https://api.github.com/repos/openatx/uiautomator2/assignees{/user}\",\n" +
                "      \"branches_url\": \"https://api.github.com/repos/openatx/uiautomator2/branches{/branch}\",\n" +
                "      \"tags_url\": \"https://api.github.com/repos/openatx/uiautomator2/tags\",\n" +
                "      \"blobs_url\": \"https://api.github.com/repos/openatx/uiautomator2/git/blobs{/sha}\",\n" +
                "      \"git_tags_url\": \"https://api.github.com/repos/openatx/uiautomator2/git/tags{/sha}\",\n" +
                "      \"git_refs_url\": \"https://api.github.com/repos/openatx/uiautomator2/git/refs{/sha}\",\n" +
                "      \"trees_url\": \"https://api.github.com/repos/openatx/uiautomator2/git/trees{/sha}\",\n" +
                "      \"statuses_url\": \"https://api.github.com/repos/openatx/uiautomator2/statuses/{sha}\",\n" +
                "      \"languages_url\": \"https://api.github.com/repos/openatx/uiautomator2/languages\",\n" +
                "      \"stargazers_url\": \"https://api.github.com/repos/openatx/uiautomator2/stargazers\",\n" +
                "      \"contributors_url\": \"https://api.github.com/repos/openatx/uiautomator2/contributors\",\n" +
                "      \"subscribers_url\": \"https://api.github.com/repos/openatx/uiautomator2/subscribers\",\n" +
                "      \"subscription_url\": \"https://api.github.com/repos/openatx/uiautomator2/subscription\",\n" +
                "      \"commits_url\": \"https://api.github.com/repos/openatx/uiautomator2/commits{/sha}\",\n" +
                "      \"git_commits_url\": \"https://api.github.com/repos/openatx/uiautomator2/git/commits{/sha}\",\n" +
                "      \"comments_url\": \"https://api.github.com/repos/openatx/uiautomator2/comments{/number}\",\n" +
                "      \"issue_comment_url\": \"https://api.github.com/repos/openatx/uiautomator2/issues/comments{/number}\",\n" +
                "      \"contents_url\": \"https://api.github.com/repos/openatx/uiautomator2/contents/{+path}\",\n" +
                "      \"compare_url\": \"https://api.github.com/repos/openatx/uiautomator2/compare/{base}...{head}\",\n" +
                "      \"merges_url\": \"https://api.github.com/repos/openatx/uiautomator2/merges\",\n" +
                "      \"archive_url\": \"https://api.github.com/repos/openatx/uiautomator2/{archive_format}{/ref}\",\n" +
                "      \"downloads_url\": \"https://api.github.com/repos/openatx/uiautomator2/downloads\",\n" +
                "      \"issues_url\": \"https://api.github.com/repos/openatx/uiautomator2/issues{/number}\",\n" +
                "      \"pulls_url\": \"https://api.github.com/repos/openatx/uiautomator2/pulls{/number}\",\n" +
                "      \"milestones_url\": \"https://api.github.com/repos/openatx/uiautomator2/milestones{/number}\",\n" +
                "      \"notifications_url\": \"https://api.github.com/repos/openatx/uiautomator2/notifications{?sin ce,all,participating}\",\n" +
                "      \"labels_url\": \"https://api.github.com/repos/openatx/uiautomator2/labels{/name}\",\n" +
                "      \"releases_url\": \"https://api.github.com/repos/openatx/uiautomator2/releases{/id}\",\n" +
                "      \"deployments_url\": \"https://api.github.com/repos/openatx/uiautomator2/deployments\",\n" +
                "      \"created_at\": \"2017-09-17T12:20:42Z\",\n" +
                "      \"updated_at\": \"2021-09-25T09:40:21Z\",\n" +
                "      \"pushed_at\": \"2021-09-11T10:00:06Z\",\n" +
                "      \"git_url\": \"git://github.com/openatx/uiautomator2.git\",\n" +
                "      \"ssh_url\": \"git@github.com:openatx/uiautomator2.git\",\n" +
                "      \"clone_url\": \"https://github.com/openatx/uiautomator2.git\",\n" +
                "      \"svn_url\": \"https://github.com/openatx/uiautomator2\",\n" +
                "      \"homepage\": null,\n" +
                "      \"size\": 2039,\n" +
                "      \"stargazers_count\": 3873,\n" +
                "      \"watchers_count\": 3873,\n" +
                "      \"language\": \"Python\",\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_projects\": true,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"forks_count\": 975,\n" +
                "      \"mirror_url\": null,\n" +
                "      \"archived\": false,\n" +
                "      \"disabled\": false,\n" +
                "      \"open_issues_count\": 240,\n" +
                "      \"license\": {\n" +
                "        \"key\": \"mit\",\n" +
                "        \"name\": \"MIT License\",\n" +
                "        \"spdx_id\": \"MIT\",\n" +
                "        \"url\": \"https://api.github.com/licenses/mit\",\n" +
                "        \"node_id\": \"MDc6TGljZW5zZTEz\"\n" +
                "      },\n" +
                "      \"allow_forking\": true,\n" +
                "      \"forks\": 975,\n" +
                "      \"open_issues\": 240,\n" +
                "      \"watchers\": 3873,\n" +
                "      \"default_branch\": \"master\",\n" +
                "      \"score\": 1.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 37489525,\n" +
                "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkzNzQ4OTUyNQ==\",\n" +
                "      \"name\": \"pytest\",\n" +
                "      \"full_name\": \"pytest-dev/pytest\",\n" +
                "      \"private\": false,\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"pytest-dev\",\n" +
                "        \"id\": 8897583,\n" +
                "        \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjg4OTc1ODM=\",\n" +
                "        \"avatar_url\": \"https://avatars.githubusercontent.com/u/8897583?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/pytest-dev\",\n" +
                "        \"html_url\": \"https://github.com/pytest-dev\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/pytest-dev/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/pytest-dev/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/pytest-dev/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/pytest-dev/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/pytest-dev/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/pytest-dev/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/pytest-dev/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/pytest-dev/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/pytest-dev/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"html_url\": \"https://github.com/pytest-dev/pytest\",\n" +
                "      \"description\": \"The pytest framework makes it easy to write small tests, yet scales to support complex functional testing\",\n" +
                "      \"fork\": false,\n" +
                "      \"url\": \"https://api.github.com/repos/pytest-dev/pytest\",\n" +
                "      \"forks_url\": \"https://api.github.com/repos/pytest-dev/pytest/forks\",\n" +
                "      \"keys_url\": \"https://api.github.com/repos/pytest-dev/pytest/keys{/key_id}\",\n" +
                "      \"collaborators_url\": \"https://api.github.com/repos/pytest-dev/pytest/collaborators{/collaborator}\",\n" +
                "      \"teams_url\": \"https://api.github.com/repos/pytest-dev/pytest/teams\",\n" +
                "      \"hooks_url\": \"https://api.github.com/repos/pytest-dev/pytest/hooks\",\n" +
                "      \"issue_events_url\": \"https://api.github.com/repos/pytest-dev/pytest/issues/events{/number}\",\n" +
                "      \"events_url\": \"https://api.github.com/repos/pytest-dev/pytest/events\",\n" +
                "      \"assignees_url\": \"https://api.github.com/repos/pytest-dev/pytest/assignees{/user}\",\n" +
                "      \"branches_url\": \"https://api.github.com/repos/pytest-dev/pytest/branches{/branch}\",\n" +
                "      \"tags_url\": \"https://api.github.com/repos/pytest-dev/pytest/tags\",\n" +
                "      \"blobs_url\": \"https://api.github.com/repos/pytest-dev/pytest/git/blobs{/sha}\",\n" +
                "      \"git_tags_url\": \"https://api.github.com/repos/pytest-dev/pytest/git/tags{/sha}\",\n" +
                "      \"git_refs_url\": \"https://api.github.com/repos/pytest-dev/pytest/git/refs{/sha}\",\n" +
                "      \"trees_url\": \"https://api.github.com/repos/pytest-dev/pytest/git/trees{/sha}\",\n" +
                "      \"statuses_url\": \"https://api.github.com/repos/pytest-dev/pytest/statuses/{sha}\",\n" +
                "      \"languages_url\": \"https://api.github.com/repos/pytest-dev/pytest/languages\",\n" +
                "      \"stargazers_url\": \"https://api.github.com/repos/pytest-dev/pytest/stargazers\",\n" +
                "      \"contributors_url\": \"https://api.github.com/repos/pytest-dev/pytest/contributors\",\n" +
                "      \"subscribers_url\": \"https://api.github.com/repos/pytest-dev/pytest/subscribers\",\n" +
                "      \"subscription_url\": \"https://api.github.com/repos/pytest-dev/pytest/subscription\",\n" +
                "      \"commits_url\": \"https:// api.github.com/repos/pytest-dev/pytest/commits{/sha}\",\n" +
                "      \"git_commits_url\": \"https://api.github.com/repos/pytest-dev/pytest/git/commits{/sha}\",\n" +
                "      \"comments_url\": \"https://api.github.com/repos/pytest-dev/pytest/comments{/number}\",\n" +
                "      \"issue_comment_url\": \"https://api.github.com/repos/pytest-dev/pytest/issues/comments{/number}\",\n" +
                "      \"contents_url\": \"https://api.github.com/repos/pytest-dev/pytest/contents/{+path}\",\n" +
                "      \"compare_url\": \"https://api.github.com/repos/pytest-dev/pytest/compare/{base}...{head}\",\n" +
                "      \"merges_url\": \"https://api.github.com/repos/pytest-dev/pytest/merges\",\n" +
                "      \"archive_url\": \"https://api.github.com/repos/pytest-dev/pytest/{archive_format}{/ref}\",\n" +
                "      \"downloads_url\": \"https://api.github.com/repos/pytest-dev/pytest/downloads\",\n" +
                "      \"issues_url\": \"https://api.github.com/repos/pytest-dev/pytest/issues{/number}\",\n" +
                "      \"pulls_url\": \"https://api.github.com/repos/pytest-dev/pytest/pulls{/number}\",\n" +
                "      \"milestones_url\": \"https://api.github.com/repos/pytest-dev/pytest/milestones{/number}\",\n" +
                "      \"notifications_url\": \"https://api.github.com/repos/pytest-dev/pytest/notifications{?since,all,participating}\",\n" +
                "      \"labels_url\": \"https://api.github.com/repos/pytest-dev/pytest/labels{/name}\",\n" +
                "      \"releases_url\": \"https://api.github.com/repos/pytest-dev/pytest/releases{/id}\",\n" +
                "      \"deployments_url\": \"https://api.github.com/repos/pytest-dev/pytest/deployments\",\n" +
                "      \"created_at\": \"2015-06-15T20:28:27Z\",\n" +
                "      \"updated_at\": \"2021-09-25T23:08:01Z\",\n" +
                "      \"pushed_at\": \"2021-09-26T00:11:26Z\",\n" +
                "      \"git_url\": \"git://github.com/pytest-dev/pytest.git\",\n" +
                "      \"ssh_url\": \"git@github.com:pytest-dev/pytest.git\",\n" +
                "      \"clone_url\": \"https://github.com/pytest-dev/pytest.git\",\n" +
                "      \"svn_url\": \"https://github.com/pytest-dev/pytest\",\n" +
                "      \"homepage\": \"https://pytest.org\",\n" +
                "      \"size\": 27135,\n" +
                "      \"stargazers_count\": 7777,\n" +
                "      \"watchers_count\": 7777,\n" +
                "      \"language\": \"Python\",\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_projects\": true,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"forks_count\": 1824,\n" +
                "      \"mirror_url\": null,\n" +
                "      \"archived\": false,\n" +
                "      \"disabled\": false,\n" +
                "      \"open_issues_count\": 726,\n" +
                "      \"license\": {\n" +
                "        \"key\": \"mit\",\n" +
                "        \"name\": \"MIT License\",\n" +
                "        \"spdx_id\": \"MIT\",\n" +
                "        \"url\": \"https://api.github.com/licenses/mit\",\n" +
                "        \"node_id\": \"MDc6TGljZW5zZTEz\"\n" +
                "      },\n" +
                "      \"allow_forking\": true,\n" +
                "      \"forks\": 1824,\n" +
                "      \"open_issues\": 726,\n" +
                "      \"watchers\": 7777,\n" +
                "      \"default_branch\": \"main\",\n" +
                "      \"score\": 1.0\n" +
                "    }\n" +
                "  ]\n" +
                "}", type)
    }
}