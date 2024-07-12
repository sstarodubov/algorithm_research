
function dfs(node, d, md, ret = []) {
    if (Number.isInteger(node)) {
        ret.push(node)
        return
    }
    if (d > md) {
        ret.push(node)
    } else {

        for (const child of node) {
            dfs(child, d + 1, md, ret)
        }
    }
}

function flat(arr, n) {
    ret = []

    dfs(arr, 0, n, ret)
    return ret
}

