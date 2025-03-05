import { Link } from "react-router-dom";

function Home() {

    return (
        <>
            <h3>Home</h3>

            <p><Link to="/counter">Counter</Link></p>
            <p><Link to="/login">Login</Link></p>

            <p><Link to="/mobile/all">View All Mobiles</Link></p>
            <p><Link to="/mobile/add">Add New Mobile</Link></p>
        </>
    )
}

export default Home;