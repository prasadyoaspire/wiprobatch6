import { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function FetchAllMobiles() {

    const [mobiles, setMobiles] = useState([]);

    // Similar to componentDidMount and componentDidUpdate
    useEffect(() => {
        axios.get("http://localhost:8081/mobile/").then(resp => setMobiles(resp.data));
    },[])

    return (
        <>
            <h4>All Mobiles</h4>
            {
                mobiles.map(mobile => <div>
                    <p>
                        {mobile.mobileId} {mobile.mobileName} {mobile.price} &nbsp;&nbsp;
                        <Link to={`/mobile/details/${mobile.mobileId}`}>View</Link> &nbsp;&nbsp;
                        <Link to={`/mobile/update/${mobile.mobileId}`}>Edit</Link>&nbsp;&nbsp;
                        <Link to={`/mobile/delete/${mobile.mobileId}`}>Delete</Link>&nbsp;&nbsp;
                    </p>
                </div>)
            }
            <Link to="/"><button>Back To Home</button></Link>
        </>
    )
}

export default FetchAllMobiles;