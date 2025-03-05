import { useState } from 'react';

function LoginForm() {

    const [uname,setUname] = useState('');
    const [upwd, setUpwd] = useState('');

    // const handleUserName = (event) => {
    //     // console.log(event.target.value);
    //     setUname(event.target.value);
    // }

    // const handlePassword = (event) => {
    //     // console.log(event.target.value);
    //     setUpwd(event.target.value);
    // }

    const doLogin = () => {

        if(upwd==='1234') {
            alert("Welcome "+uname);
        }
        else {
            alert("Invalid login");
        }
    }
 
    return(
        <>
            <div>
                <label>Username</label>
                <input type="text" name="uname" id="uname" value={uname} 
                onChange={(event)=> setUname(event.target.value)}/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="upwd" id="upwd" value={upwd}
                onChange={(event)=> setUpwd(event.target.value)}/>
            </div>        
            <button onClick={doLogin}>Login</button>
        </>
    )
}

export default LoginForm;