import { useState } from "react";

function Counter() {

    const [counter, setCounter] = useState(0); //declare state 

    let increment = () => {
        //update the state 
        setCounter(counter + 1);
    }

    let decrement = () => {
        //update the state
        setCounter(counter - 1);
    }

    return (
        <>
            <h3>Counter Component</h3>
            <h4>Counter : {counter}</h4>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
        </>
    )
}

export default Counter;