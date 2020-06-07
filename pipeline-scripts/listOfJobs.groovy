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


def ArrayList listProjectItems() {
    Folder projectFolder = findFolder('TestJobs')
    def myList = []

    if (projectFolder) {

        for (job in projectFolder.items) {
            StringBuilder b = new StringBuilder()
            b.append('TestJobs/')
            String jobName
            b.append(job)
            jobName=b
            myList.add(jobName)
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