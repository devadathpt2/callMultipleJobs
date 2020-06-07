import com.cloudbees.hudson.plugins.folder.Folder
import jenkins.model.Jenkins

def Folder findFolder(String folderName) {
    for (folder in Jenkins.instance.items) {
        if (folder.name == folderName) {
            return folder
        }
    }
    return null
}


def String listProjectItems() {
    Folder projectFolder = findFolder('TestJobs')
    StringBuilder b = new StringBuilder()
    string jobName
    if (projectFolder) {

        for (job in projectFolder.items.sort{it.name}) {
            b.append(job)
            jobName=b
        }
        return jobName // dump the initial comma
    }
    return b.toString()
}

def printSomething()
{
    println("It's SUCCESS!!!!!!!")
}


return this