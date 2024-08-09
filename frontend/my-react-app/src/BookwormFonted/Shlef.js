import { useState } from "react";
import Myshelf from "./Buyshelf";
import UserRentShelf from "./UserRentShlef";

const Shelf = () =>{
    const [showComponentOne, setShowComponentOne] = useState(false);
  const [showComponentTwo, setShowComponentTwo] = useState(false);

  const handleFirstButtonClick = () => {
    setShowComponentOne(true);
    setShowComponentTwo(false);
  };

  const handleSecondButtonClick = () => {
    setShowComponentOne(false);
    setShowComponentTwo(true);
  };
    return (
        
            <div>
              <button onClick={handleFirstButtonClick}>Load Buyshelf</button>
              <button onClick={handleSecondButtonClick}>Load RentShelf</button>
        
              {showComponentOne && < Myshelf/>}
              {showComponentTwo && <UserRentShelf />}
            </div>
          );
    
}
export default Shelf;