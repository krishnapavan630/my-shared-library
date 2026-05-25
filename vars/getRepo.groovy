def call(String addr, String branchName){
    echo "Trying to clone the ${addr} from ${branchName}"
    git url: addr, branch: branchName
    echo "Checkout completed"
}
