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
    def myList = []
    StringBuilder b = new StringBuilder()
    b.append(',TestJobs/')
    if (projectFolder) {

        for (job in projectFolder.items) {

//            String jobName
            b.append(',')
            b.append(job)
//            jobName=b
//            myList.add(jobName)
        }
        return b // dump the initial comma
    }
    return b.toString()
}

def printSomething()
{
    println("It's SUCCESS!!!!!!!")
}


return this