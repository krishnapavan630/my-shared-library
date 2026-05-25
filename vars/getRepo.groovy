def call(String addr, String branch){
    echo "Trying to clone the ${addr} from ${branch}"
    git url: addr, branch: branchName
    echo "Checkout completed"
}