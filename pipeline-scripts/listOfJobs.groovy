import com.cloudbees.hudson.plugins.folder.Folder
import jenkins.model.Jenkins

Folder findFolder(String folderName) {
    for (folder in Jenkins.instance.items) {
        if (folder.name == folderName) {
            return folder
        }
    }
    return null
}


String listProjectItems() {
    Folder projectFolder = findFolder('TestJobs')
    StringBuilder b = new StringBuilder()
    if (projectFolder) {

        for (job in projectFolder.items.sort{it.name.toUpperCase()}) {
            b.append(',').append(job)
        }
        return b.substring(1) // dump the initial comma
    }
    return b.toString()
}

return [
        listProjectItems: this.&listProjectItems
]