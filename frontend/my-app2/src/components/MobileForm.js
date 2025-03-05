import { useState } from "react";
import axios from 'axios';

function MobileForm() {

    const [mname, setMname] = useState('');
    const [mprice, setMprice] = useState('');
    const [mfd, setMfd] = useState('');
    const [mcompany, setMcompany] = useState('');

    const handleSubmit = () => {

        const payload = {
            mobileName: mname,
            price: mprice,
            mfd: mfd,
            companyName: mcompany
        }

        axios.post("http://localhost:8081/mobile/", payload)
            .then(resp => {
                alert("Mobile saved with id: " + resp.data.mobileId);
                resetForm();
            }
            );
    }

    const resetForm = () => {
        setMname('');
        setMprice('');
        setMfd('');
        setMcompany('');
    }

    return (
        <>
            <h3>Mobile Form</h3>
            <div>
                <label>Name</label>
                <input type="text" name="mname" value={mname}
                    onChange={(event) => setMname(event.target.value)} />
            </div>
            <div>
                <label>Price</label>
                <input type="text" name="mprice" value={mprice}
                    onChange={(event) => setMprice(event.target.value)} />
            </div>
            <div>
                <label>MFD</label>
                <input type="date" name="mfd" value={mfd}
                    onChange={(event) => setMfd(event.target.value)} />
            </div>
            <div>
                <label>Company Name</label>
                <input type="text" name="mcompany" value={mcompany}
                    onChange={(event) => setMcompany(event.target.value)} />
            </div>

            <input type="submit" onClick={handleSubmit} />
            <input type="button" onClick={resetForm} value="Reset" />
        </>
    )
}

export default MobileForm;