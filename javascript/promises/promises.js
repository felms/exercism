export const promisify = (callbackFn) => {

  return (parameter) => {
    return new Promise((resolve, reject) => {
      callbackFn(parameter, (error, data) => {
        if (error) {
          return reject(error);
        } else {
          return resolve(data);
        }
      });
    });
  };

};

export const all = async (promises) => {

  if (!promises) {
    return Promise.resolve(promises);
  }

  let resolved = [];

  try {
    for (let p of promises) {
      resolved.push(await p);
    }
  } catch (error) {
    return Promise.reject(error);
  }

  return Promise.resolve(resolved);

};

export const allSettled = async (promises) => {

  if (!promises) {
    return Promise.resolve(promises);
  }

  if (promises.length === 0) {
    return Promise.resolve([]);
  }

  let resolved = [];

  try {
    for (let promise of promises) {
      resolved.push(await promise);
    }
  } catch(error) {
    resolved.push(error);
  }

  return Promise.resolve(resolved);
};

export const race = (promises) => {

  if (!promises) {
    return Promise.resolve(promises);
  }

  if (promises.length === 0) {
    return Promise.resolve([]);
  }

  return new Promise((resolve, reject) => {

    for (let p of promises) {
      p.then(data => resolve(data))
        .catch(error => reject(error));
    }

  });

};

export const any = (promises) => {

  if (!promises) {
    return Promise.resolve(promises);
  }

  if (promises.length === 0) {
    return Promise.resolve([]);
  }

  let rejected = [];

  return new Promise((resolve, reject) => {

    for (let promise of promises) {

      promise.then(data => {
        resolve(data)
      }).catch(error => {
        rejected.push(error)
        if (rejected.length === promises.length) {
          reject(rejected);
        }

      });

    }

  });

};
