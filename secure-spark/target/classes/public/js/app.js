const app = (() => {
    const login = () => {

        const email = $("#email").val();
        const password = $("#password").vale();

        const promise = $.post({
            url: "/login",
            type: 'POST',
            data: JSON.stringify({email:email, password:password}),
            contentType: "application/json"
        }).then(response => {
            console.log(response);
        }).catch(
            error => {
                console.log(`Error: ${error}`);
            }
        );
    }
    return {
        login : login
    }
})();