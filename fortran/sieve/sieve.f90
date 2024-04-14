module sieve
    implicit none

    contains

    function primes(limit) result(array) 
        integer, intent(in) :: limit
        integer, allocatable :: array(:)
        integer, allocatable :: tempArray(:)

        logical, dimension(limit) :: sieveArray

        integer :: i
        integer :: j
        integer :: k
        integer :: sz

        allocate(array(0))

        ! init the sieve
        sieveArray(:) = .true.
        sieveArray(1) = .false.

        do i = 1, limit
            if (sieveArray(i) .eqv. .true.) then

                ! reallocate the array 
                ! to append the new prime found
                sz = size(array)
                allocate(tempArray(sz + 1))
                do k = 1, sz
                    tempArray(k) = array(k)
                end do

                tempArray(sz + 1) = i
                deallocate(array)
                call move_alloc(tempArray, array)

                ! update the sieve
                do j = i + i, limit, i
                    sieveArray(j) = .false.
                end do
            end if
        end do

    end function primes

end module sieve
