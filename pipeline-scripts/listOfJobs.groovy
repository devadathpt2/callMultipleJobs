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

def jobList = []

def ArrayList listProjectItems() {
    Folder projectFolder = findFolder('TestJobs')
    StringBuilder b = new StringBuilder()
    if (projectFolder) {

        for (job in projectFolder.items.sort{it.name.toUpperCase()}) {
//            b.append(',').append(job.fullName)
            jobList.add(job)
        }
        return jobList // dump the initial comma
    }
    return b.toString()
}

def printSomething()
{
    println("It's SUCCESS!!!!!!!")
}


return this