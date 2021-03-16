const app = (() => {

    const post = (callBack) => {
        const promise = $.get({
            url: "/conection"
        }).then(data => {
            console.log(data)
            callBack(JSON.stringify(data));
        }).catch(
            error => {
                console.log(`Error : ${error}`);
            }
        );
    }

    const resetData = (data) => {
        $("#response").append(data);
    }

    const conexion = () => {
        post(resetData);
    }

    return{
        conexion: conexion
    }
})();