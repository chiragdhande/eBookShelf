import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from '../App';



import TypeOfProduct from './TypeOfProduct';
import Language from './Languages';
import Product from './Product';

import Home from './Home';
import Logindemo from '../Lgoindemo';
import RegisterPage from './RegisterPage';
import Forgetpass from './Forgetpass';
import Cart from './Cart';

import History from './History';
import ContactUs from './Contactus';
import AboutUs from './Abouts';

import Shelf from './Shlef';
import Profile from './Profile';
import Authors from './Admin/Authors';
import AuthorRoyalties from './Admin/AuthorRoyalties';
import Publisher from './Admin/Publisher';
import PublisherRoyalties from './Admin/PublisherRoyalty';
import BackupBuy from './Admin/BackupBuy';
import BackupRent from './Admin/BackupRant';
import Errorpage from './Errorpage';
import Demo from '../Demo';


const Routing =()=>{

    return(
        <div>
            <BrowserRouter>
            
            
            <Routes> 
                 <Route path='/' element={<App/>}>
                 <Route path='/' element={<Home/>}/> 
                 <Route path='/login' element={<Logindemo/>}/> 
                 <Route path='type' element={< TypeOfProduct/>}/> 
                 <Route path='/typelanguage/:typeId' element={<Language/>}/>
                 <Route path='/ProductByid/:languageId' element={<Product/>}/>
                
                 <Route path='/register' element={<RegisterPage/>}/> 
                 <Route path='/forgetpass' element={<Forgetpass/>}/>
                 <Route path='/cart' element={<Cart/>}/>
                 <Route path='/Myshelf' element={<Shelf/>}/>
                 <Route path='/history' element={<History/>}/>
                 <Route path='/contactus' element={<ContactUs/>}/>
                 <Route path='/Aboutus' element={<AboutUs/>}/>
                 <Route path='/profile' element={<Profile/>}/>
                 <Route path ='/authors' element={<Authors/>}/>
                 <Route path ='/publisher' element={<Publisher/>}/>
                 <Route path='/authorroylties/:id/:name' element={<AuthorRoyalties/>}/>
                 <Route path='/publisherroylties/:id/:name' element={<PublisherRoyalties/>}/>
                 <Route path ='/buybackup' element={<BackupBuy/>}/>
                 <Route path ='/rentbackup' element={<BackupRent/>}/>
                 <Route path ='*' element={<Errorpage/>}/>
                 <Route path='/demo' element ={<Demo/>}/>
                  </Route>
                 
               
            </Routes>
            
            </BrowserRouter>
        </div>
    )
}
export default Routing;