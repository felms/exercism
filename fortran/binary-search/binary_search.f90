module binary_search
  implicit none
contains

  function find(array, val) result(idx)
    integer, dimension(:), intent(in) :: array
    integer, intent(in) :: val
    integer :: idx, low, high, middle

    low = 1
    high = size(array)
    idx = -1

    do while (low <= high)
        middle = (low + high) / 2

        if (array(middle) .eq. val) then
            idx = middle
            exit
        end if

        if (array(middle) > val) then
            high = middle - 1
        else
            low = middle + 1
        end if

    end do

  end function

end module
