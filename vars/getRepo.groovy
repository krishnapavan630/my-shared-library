def call(String addr, String branchName){
    echo "Trying to clone the ${addr} from ${branch}"
    git url: addr, branch: branchName
    echo "Checkout completed"
}
