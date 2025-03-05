import Counter from './components/Counter';
import DeleteMobile from './components/DeleteMobile';
import EditMobile from './components/EditMobile';
import FetchAllMobiles from './components/FetchAllMobiles';
import FetchMobileDetails from './components/FetchMobileDetails';
import Home from './components/Home';
import LoginForm from './components/LoginForm';
import MobileForm from './components/MobileForm';
import logo from './logo.svg';
// import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Home/>}/>

        <Route path='/counter' element={<Counter/>}/>

        <Route path="/mobile/all" element={<FetchAllMobiles/>}/>
        <Route path="/mobile/add" element={<MobileForm/>}/>
        <Route path='/mobile/details/:mid' element={<FetchMobileDetails/>}/>
        <Route path='/mobile/update/:id' element={<EditMobile/>}/>
        <Route path='/mobile/delete/:id' element={<DeleteMobile/>}/>

        <Route path='/login' element={<LoginForm/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
