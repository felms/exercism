module Meetup
  ( meetup
  , Week(..)
  ) where

import Prelude

import Data.Array (catMaybes, find, (..))
import Data.Date (Date, Month, Weekday, Year, weekday, canonicalDate, lastDayOfMonth)
import Data.Enum (fromEnum, toEnum)
import Data.Maybe (Maybe)

data Week
  = First
  | Second
  | Third
  | Fourth
  | Last
  | Teenth

meetup :: Year -> Month -> Week -> Weekday -> Maybe Date
meetup y m w wd = 
   find (\d -> weekday d == wd) $ canonicalDate y m <$> catMaybes (toEnum <$> days)
    where
        lastDays = fromEnum $ lastDayOfMonth y m
        days = case w of
                First   ->  1 ..  7
                Second  ->  8 .. 14
                Third   -> 15 .. 21
                Fourth  -> 22 .. 28
                Teenth  -> 13 .. 19
                Last    -> (lastDays - 6) .. lastDays

